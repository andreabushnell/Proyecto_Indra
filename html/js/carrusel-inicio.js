const contenedorSlides = document.getElementById("contenedor-slides");
const slide = document.querySelector(".slide");
const botonPrevio = document.getElementById("flecha-slide-previo");
const botonSiguiente = document.getElementById("flecha-slide-siguiente");

botonSiguiente.addEventListener("click", () => {
  const slideWidth = slide.clientWidth;
  contenedorSlides.scrollLeft += slideWidth;
});

botonPrevio.addEventListener("click", () => {
  const slideWidth = slide.clientWidth;
  contenedorSlides.scrollLeft -= slideWidth;
});


