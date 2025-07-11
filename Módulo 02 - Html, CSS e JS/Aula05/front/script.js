//Vetor
let produtos =[];

//Requisição para obter todos os produtos
fetch('http://localhost:3000/produtos')
.then(retorno => retorno.json())
.then(p => {
    produtos = p;
    renderizarTabela();
}
);

//Função para gerar a tabela
let renderizarTabela = () => {
    let tabela = document.getElementById('tabela');

    //limpar tabela
    tabela.innerHTML = '';

    //laço de repetição
    for(let indice=0; indice<produtos.length; indice++){
        //criar linha de tabela
        let linha = tabela.insertRow(-1);

        //criar colunas<td>
        let colunaId         = linha.insertCell(0);
        let colunaNome       = linha.insertCell(1);
        let colunaMarca      = linha.insertCell(2);
        let colunaValor      = linha.insertCell(3);
        let colunaSelecionar = linha.insertCell(4);

        colunaId.innerText    = produtos[indice].id;
        colunaNome.innerText  = produtos[indice].nome;
        colunaMarca.innerText = produtos[indice].marca;
        colunaValor.innerText = produtos[indice].valor;
        colunaSelecionar.innerHTML = `'<button onclick='selecionar(${indice})' class='btn btn-primary'>Selecionar<button>`;
    }
}

//função para cadastrar produtos
const cadastrar = () => {
    //Obter os inputs
    let nome  = document.getElementById('nome');
    let marca = document.getElementById('marca');
    let valor = document.getElementById('valor');

    //gerar objeto produto
    let obj = {
        'nome':nome.value,
        'marca':marca.value,
        'valor':parseFloat(valor.value)
    }
    
    //requisição
    fetch('http://localhost:3000/produtos',
        {
            method:'POST',
            body:JSON.stringify(obj),
            headers:{'Content-Type':'application/json'}
        }
    ).then(res => res.json())
    .then(p =>{ 
        //armazenar o produto no vetor
        produtos.push(p);

        //gerar o indice do produto no vetor
        let indice = produtos.length-1;

        let tabela = document.getElementById('tabela');

                //criar linha de tabela
        let linha = tabela.insertRow(-1);

        //criar colunas<td>
        let colunaId         = linha.insertCell(0);
        let colunaNome       = linha.insertCell(1);
        let colunaMarca      = linha.insertCell(2);
        let colunaValor      = linha.insertCell(3);
        let colunaSelecionar = linha.insertCell(4);

        colunaId.innerText    = p.id;
        colunaNome.innerText  = p.nome;
        colunaMarca.innerText = p.marca;
        colunaValor.innerText = p.valor;
        colunaSelecionar.innerHTML = `<button onclick=' selecionar(${indice})' class='btn btn-primary'>Selecionar</button>`;

        //limpar inputs
        nome.value  = '';
        marca.value = '';
        valor.value = '';

        //Focus
        nome.focus();
    });
}

//função para selecionar um produto especifico
const selecionar = (indice) => {
    //Selecionar todos os elementos de formulario

    let id    = document.getElementById('id');
    let nome  = document.getElementById('nome');
    let marca = document.getElementById('marca');
    let valor = document.getElementById('valor');

    let btnCadastrar = document.getElementById('btnCadastrar');
    let btnAlterar   = document.getElementById('btnAlterar');
    let btnRemover   = document.getElementById('btnRemover');
    let btnCancelar  = document.getElementById('btnCancelar');


    //obter objeto de produto
    let obj = produtos[indice];

    //Preencher inputs (text)
    id.value    = obj.id;
    nome.value  = obj.nome;
    marca.value = obj.marca;
    valor.value = obj.valor;

    //visibilidade dos botões
    btnCadastrar.style.display = 'none';
    btnAlterar.style.display   = 'inline-block';
    btnRemover.style.display   = 'inline-block';
    btnCancelar.style.display  = 'inline-block';
}

//função para Cancelar
const cancelar = (indice) => {
    //Selecionar todos os elementos de formulario

    let id    = document.getElementById('id');
    let nome  = document.getElementById('nome');
    let marca = document.getElementById('marca');
    let valor = document.getElementById('valor');

    let btnCadastrar = document.getElementById('btnCadastrar');
    let btnAlterar   = document.getElementById('btnAlterar');
    let btnRemover   = document.getElementById('btnRemover');
    let btnCancelar  = document.getElementById('btnCancelar');


    //Limpar inputs (text)
    id.value    = '';
    nome.value  = '';
    marca.value = '';
    valor.value = '';

    //visibilidade dos botões
    btnCadastrar.style.display = 'inline-block';
    btnAlterar.style.display   = 'none';
    btnRemover.style.display   = 'none';
    btnCancelar.style.display  = 'none';
}

//função para Alterar produtos
const alterar = () => {
    //Obter os inputs
    let id    = document.getElementById('id');
    let nome  = document.getElementById('nome');
    let marca = document.getElementById('marca');
    let valor = document.getElementById('valor');

    //gerar objeto produto
    let obj = {
        'nome':nome.value,
        'marca':marca.value,
        'valor':parseFloat(valor.value)
    }
    
    //requisição
    fetch(
        `http://localhost:3000/produtos/${id.value}`,
        {
            method:'PUT',
            body:JSON.stringify(obj),
            headers:{'Content-Type':'application/json'}
        }
    ).then(res => res.json())
    .then(p =>{ 
        //Localizar o produto no vetor
        let indice = produtos.findIndex(pessoa => pessoa.id == p.id);

        //alterar obj no vetor
        produtos[indice] = p;
        
        //Atualizar tabela
        renderizarTabela();

        //limpar inputs
        id.values   = '';
        nome.value  = '';
        marca.value = '';
        valor.value = '';

        //Focus
        nome.focus();
    });
}

//função para deletar produtos
const deletar = () => {
    //Obter os input id
    let id    = document.getElementById('id');
    
    //requisição
    fetch(
        `http://localhost:3000/produtos/${id.value}`,
        {
            method:'DELETE',
            headers:{'Content-Type':'application/json'}
        }
    ).then(res => res.json())
    .then(p =>{ 
        //Localizar o produto no vetor
        let indice = produtos.findIndex(pessoa => pessoa.id == p.id);

        //Remover obj no vetor
        produtos.splice(indice,1);
        
        //Atualizar tabela
        renderizarTabela();

        //limpar inputs
        id.values   = '';
        nome.value  = '';
        marca.value = '';
        valor.value = '';

        //Focus
        nome.focus();
    });
}