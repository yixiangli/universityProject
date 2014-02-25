$(document).ready(function(){
    $('.tip1').imageLens(); // default initialization
    $('.tip2').imageLens({ lensSize: 200 }); // set lens size
    $('#img_03').imageLens({ lensSize: 200, imageSrc: 'data_images/img5.jpg' }); // lens size + custom image
    $('#img_04').imageLens({ borderSize: 8, borderColor: '#f00' }); // new border size and color
});