const url = 'http://localhost:3000';
const form = document.getElementById('formPessoa');
const lista = document.getElementById('listaPessoas');
const inputId = document.getElementById('idPessoa');
const inputNome = document.getElementById('nome');
const inputIdade = document.getElementById('idade');

function carregarPessoas() {
    fetch(url)
        .then(res => res.json())
        .then(pessoas => {
            lista.innerHTML = '';
            pessoas.forEach(p => {
                const li = document.createElement('li');
                li.className = 'list-group-item d-flex justify-content-between align-items-center';
                li.innerHTML = `
              <div>
                <strong>${p.nome}</strong> - ${p.idade} anos
              </div>
              <div>
                <button class="btn btn-sm btn-primary me-2" onclick="editarPessoa(${p.id}, '${p.nome}', ${p.idade})">Editar</button>
                <button class="btn btn-sm btn-danger" onclick="excluirPessoa(${p.id})">Excluir</button>
              </div>
            `;
                lista.appendChild(li);
            });
        })
        .catch(err => console.error('Erro ao carregar pessoas:', err));
}

form.addEventListener('submit', (e) => {
    e.preventDefault();

    const id = inputId.value;
    const nome = inputNome.value;
    const idade = parseInt(inputIdade.value);
    const pessoa = { nome, idade };

    if (id) {
        fetch(`${url}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(pessoa),
        })
            .then(res => res.json())
            .then(() => {
                form.reset();
                carregarPessoas();
            });
    } else {
        fetch(url, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(pessoa),
        })
            .then(res => res.json())
            .then(() => {
                form.reset();
                carregarPessoas();
            });
    }
});

function editarPessoa(id, nome, idade) {
    inputId.value = id;
    inputNome.value = nome;
    inputIdade.value = idade;
}

function excluirPessoa(id) {
    if (confirm('Deseja excluir essa pessoa?')) {
        fetch(`${url}/${id}`, {
            method: 'DELETE',
        }).then(() => carregarPessoas());
    }
}

carregarPessoas();