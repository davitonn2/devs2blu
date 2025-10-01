const URL_API = 'http://localhost:3000/enderecos';
const URL_VIA_CEP = 'https://viacep.com.br/ws/';

document.addEventListener('DOMContentLoaded', () => {
    carregarEnderecos();
    configurarEventos();
});

function configurarEventos() {
    const formulario = document.getElementById('formularioEndereco');
    const inputCep = document.getElementById('cep');
    const botaoCancelar = document.getElementById('botaoCancelar');

    inputCep.addEventListener('input', formatarCep);
    inputCep.addEventListener('blur', buscarEnderecoPorCep);
    inputCep.addEventListener('keydown', (evento) => {
        if (evento.key === 'Enter') {
            evento.preventDefault();
            buscarEnderecoPorCep(evento);
        }
    });
    formulario.addEventListener('submit', manipularEnvio);
    botaoCancelar.addEventListener('click', redefinirFormulario);
}

function formatarCep(evento) {
    let valor = evento.target.value.replace(/\D/g, '');
    if (valor.length > 5) {
        valor = valor.replace(/(\d{5})(\d)/, '$1-$2');
    }
    evento.target.value = valor;
}

async function buscarEnderecoPorCep(evento) {
    const cep = evento.target.value.replace(/\D/g, '');
    if (cep.length !== 8) {
        return;
    }

    try {
        const resposta = await fetch(`${URL_VIA_CEP}${cep}/json/`);
        if (!resposta.ok) {
            throw new Error('Erro na requisição à API ViaCEP');
        }
        const dados = await resposta.json();
        if (dados.erro) {
            alert('CEP não encontrado!');
            limparCamposEndereco();
        } else {
            document.getElementById('estado').value = dados.uf || '';
            document.getElementById('cidade').value = dados.localidade || '';
            document.getElementById('bairro').value = dados.bairro || '';
            document.getElementById('logradouro').value = dados.logradouro || '';
        }
    } catch (erro) {
        console.error('Erro ao consultar CEP:', erro);
        alert('Erro ao consultar o CEP. Tente novamente.');
        limparCamposEndereco();
    }
}

function limparCamposEndereco() {
    document.getElementById('estado').value = '';
    document.getElementById('cidade').value = '';
    document.getElementById('bairro').value = '';
    document.getElementById('logradouro').value = '';
}

async function manipularEnvio(evento) {
    evento.preventDefault();
    const formulario = evento.target;
    const id = document.getElementById('id').value;

    if (!validarFormulario()) return;

    const endereco = {
        nome: document.getElementById('nome').value,
        cep: document.getElementById('cep').value,
        estado: document.getElementById('estado').value,
        cidade: document.getElementById('cidade').value,
        bairro: document.getElementById('bairro').value,
        logradouro: document.getElementById('logradouro').value
    };

    try {
        if (id) {
            await atualizarEndereco(id, endereco);
        } else {
            await criarEndereco(endereco);
        }
        redefinirFormulario();
        carregarEnderecos();
    } catch (erro) {
        alert('Erro ao salvar endereço!');
    }
}

function validarFormulario() {
    const campos = ['nome', 'cep', 'estado', 'cidade', 'bairro', 'logradouro'];
    let valido = true;

    campos.forEach(id => {
        const campo = document.getElementById(id);
        if (!campo.value) {
            campo.classList.add('erro');
            valido = false;
        } else {
            campo.classList.remove('erro');
        }
    });

    if (!valido) {
        alert('Por favor, preencha todos os campos obrigatórios!');
    }

    return valido;
}

async function criarEndereco(endereco) {
    await fetch(URL_API, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(endereco)
    });
}

async function atualizarEndereco(id, endereco) {
    await fetch(`${URL_API}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(endereco)
    });
}

async function excluirEndereco(id) {
    if (confirm('Deseja realmente excluir este endereço?')) {
        try {
            await fetch(`${URL_API}/${id}`, {
                method: 'DELETE'
            });
            carregarEnderecos();
        } catch (erro) {
            alert('Erro ao excluir endereço!');
        }
    }
}

async function carregarEnderecos() {
    try {
        const resposta = await fetch(URL_API);
        const enderecos = await resposta.json();
        const corpoTabela = document.getElementById('tabelaEnderecos');
        corpoTabela.innerHTML = '';

        enderecos.forEach(endereco => {
            const linha = document.createElement('tr');
            linha.innerHTML = `
                <td class="px-4 py-2">${endereco.nome}</td>
                <td class="px-4 py-2">${endereco.cep}</td>
                <td class="px-4 py-2">${endereco.estado}</td>
                <td class="px-4 py-2">${endereco.cidade}</td>
                <td class="px-4 py-2">${endereco.bairro}</td>
                <td class="px-4 py-2">${endereco.logradouro}</td>
                <td class="px-4 py-2">
                    <button onclick="editarEndereco('${endereco.id}')" class="bg-yellow-500 text-white px-2 py-1 rounded-md hover:bg-yellow-600">Editar</button>
                    <button onclick="excluirEndereco('${endereco.id}')" class="bg-red-500 text-white px-2 py-1 rounded-md hover:bg-red-600">Excluir</button>
                </td>
            `;
            corpoTabela.appendChild(linha);
        });
    } catch (erro) {
        alert('Erro ao carregar endereços!');
    }
}

async function editarEndereco(id) {
    try {
        const resposta = await fetch(`${URL_API}/${id}`);
        const endereco = await resposta.json();

        document.getElementById('id').value = endereco.id;
        document.getElementById('nome').value = endereco.nome;
        document.getElementById('cep').value = endereco.cep;
        document.getElementById('estado').value = endereco.estado;
        document.getElementById('cidade').value = endereco.cidade;
        document.getElementById('bairro').value = endereco.bairro;
        document.getElementById('logradouro').value = endereco.logradouro;

        document.getElementById('botaoSalvar').textContent = 'Atualizar';
        document.getElementById('botaoCancelar').classList.remove('oculto');
    } catch (erro) {
        alert('Erro ao carregar endereço para edição!');
    }
}

function redefinirFormulario() {
    document.getElementById('formularioEndereco').reset();
    document.getElementById('id').value = '';
    document.getElementById('botaoSalvar').textContent = 'Salvar';
    document.getElementById('botaoCancelar').classList.add('oculto');
    limparCamposEndereco();
    const campos = document.querySelectorAll('input');
    campos.forEach(campo => campo.classList.remove('erro'));
}