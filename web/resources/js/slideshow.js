$(document).ready(function(){
  var currentPosition = 0;
  var slideWidth = 560;
  var slides = $('.slide');
  var numberOfSlides = slides.length;
 
  // Supprime la scrollbar en JS
  $('#slidesContainer').css('overflow', 'hidden');
 
  slides
  .wrapAll('<div id="slideInner"></div>')
  // on met tous les slides en float:left pour qu'il s'affichent de manière horizontale
  .css({
    'float' : 'left',
    'width' : slideWidth
  });
 
  // La longueur de #slideInner équivaut à la somme de la longueur de tous les slides
  $('#slideInner').css('width', slideWidth * numberOfSlides);
 
  // Insert les flèches de gauche et de droite
  $('#slideshow')
    .prepend('<span class="control" id="leftControl">Move left</span>')
    .append('<span class="control" id="rightControl">Move right</span>');
 
  // Cache la flèche de gauche au début
  manageControls(currentPosition);
 
  // crée un écouteur pour l'évènement de type clic sur les div qui ont la classe .control
  $('.control')
    .bind('click', function(){
    // Determine une nouvelle position
      currentPosition = ($(this).attr('id')=='rightControl')
    ? currentPosition+1 : currentPosition-1;
 
      //Cache ou montre les flèches
      manageControls(currentPosition);
      // Move slideInner using margin-left
      $('#slideInner').animate({
        'marginLeft' : slideWidth*(-currentPosition)
      });
    });
 
  // manageControls: Cache ou montre les flèches de contrôles en fonction de la position
  function manageControls(position){
    // Hide left arrow if position is first slide
    if(position==0){ $('#leftControl').hide() }
    else{ $('#leftControl').show() }
    // Hide right arrow if position is last slide
    if(position==numberOfSlides-1){ $('#rightControl').hide() }
    else{ $('#rightControl').show() }
    }
  });


