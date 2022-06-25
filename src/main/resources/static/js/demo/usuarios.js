// Call the dataTables jQuery plugin
$(document).ready(function() {

  cargarUsuarios();
  alert("hola");

  $('#usuarios').DataTable();
});


async function cargarUsuarios() {
  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
   
  });
  const usuarios = await request.json();

  console.log(usuarios);
  let listadoHtml = '';
  for(let usuario of usuarios) {
  let usuariohtml = '<tr> <td>'+usuario.id+'</td> > <td>'+usuario.name+''+usuario.lastName+'</td><td>'+usuario.telefono+'</td><td>'+usuario.email+'</td> <td><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';
  listadoHtml += usuariohtml;
  }


  document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}
