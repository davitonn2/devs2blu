/*
    Pacotes/Dependencias
    -Express
    -Nodemon
    -Cors
    -Express-FileUpload
*/

// Importar o express
const express = require('express');

// Importar o Cors
const cors = require('cors');

// Importar o Express-FileUpload
const fileUpload = require('express-fileupload');

// Importar o path
const path = require('path');

// Criar objeto app
const app = express();

// Adicionar o CORS
app.use(cors());

// Adicionar o FileUpload
app.use(fileUpload());

// Criar rota para realizar o upload (form-data)
app.post('/', (req, res) => {
    // Obter o arquivo
    const arquivo = req.files.arquivo;

    // Definir caminho do Upload e o nome do arquivo
    const destino = path.join(__dirname, 'uploads', arquivo.name);

    // Mover o arquivo
    arquivo.mv(destino);

    // Retorno da API
    res.status(200).json({mensagem:'Upload realizado com sucesso!'})
});

// Servidor
app.listen(8080);