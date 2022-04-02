const select= document.querySelector( '#select');
const ocpiones= document.querySelector('#opciones');
const contidoselct=document.querySelector('#select .contenido-select');

document.querySelectorAll('#opciones > .opcion').forEach((opcion)=>{
    opcion.addEventListener('click',(e)=>{
        e.preventDefault();
        console.log(e.currentTarget.innerHTML);
        contidoselct.innerHTML=e.currentTarget.innerHTML;
        opciones.classList.toggle('active');

    } );
});

select.addEventListener('click',()=>{
    select.classList.toggle('active')
    ocpiones.classList.toggle('active')
});