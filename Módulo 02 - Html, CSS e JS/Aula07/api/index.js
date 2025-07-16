//Importar dependencia/pacote do Express
const express = require('express')

//Obejto Express (Manipular notas e o servidor)
const app = express()

//Habilitar receber objets JSON nas requisições
app.use(express.json());

//Vetor para armazenar dados pessoas
let vetor = [
    {id:1, nome: 'Alice', idade: 23},
    {id:2, nome: 'Davi', idade: 17}
];

//Porta
const port = 3000

//Rota para efetuar uma requisição GET
app.get('/minhaRota', (req, res) => {
  res.status(201).json(vetor);
})

//Rota para efetuar uma requisição POST
app.post('/', (req, res) => {
    res.send(req.body);
})


//Servidor
app.listen(port)
