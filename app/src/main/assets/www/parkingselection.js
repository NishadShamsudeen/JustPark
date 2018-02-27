function checker(){
	
var all_location_id = document.querySelectorAll('input[name="seat[]"]:checked');
var counter = document.querySelectorAll('input[name="seat[]"]:checked').length;

var aIds = [];

for(var x = 0, l = all_location_id.length; x < l;  x++)
{
    aIds.push(all_location_id[x].value);
}

var str = aIds.join();

//alert(strlength);

window.ob.fetchString(str,counter);
}










          

