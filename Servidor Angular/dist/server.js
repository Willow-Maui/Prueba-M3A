let express = require('express');
let path = require('path');
let app = express();
let port = 8089;

app.use(express.static('M3A-prueba'));

app.get('*', (req, res, next) => {
  res.sendFile(path.resolve('dist/M3A-prueba/index.html'));
});

app.listen(port, () => {
  console.log('El servidor express se ha iniciado en el puerto ' + port);
});