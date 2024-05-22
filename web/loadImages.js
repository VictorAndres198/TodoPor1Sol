//funcion´para cargar las imagenes del admin layout

(function setImgPath(){
    document.getElementById("logoBotica").
            //Colocar la ruta relativa del Logo  a tu frm
            setAttribute("src","../../resources/img/home/Logo.png");
    document.getElementById("adminImg").
            //Colocar la ruta relativa del la Img del Admin relativa 
            setAttribute("src","../../resources/img/admin/admin.png");
   document.querySelectorAll("img").forEach(e=>{
       if(e.getAttribute("id")==="cheuron"){
           //Colocar la ruta relativa del la icono de la flecha
           e.setAttribute("src","../../resources/img/admin/cheuron-abajo.png");
       }
   });    
   document.querySelectorAll("img").forEach(e=>{
       if(e.getAttribute("id")==="cheuron2"){
           //Colocar la ruta relativa del la icono de la flecha
           e.setAttribute("src","../../resources/img/admin/cheuron-abajo2.png");
       }
   });  
})();

