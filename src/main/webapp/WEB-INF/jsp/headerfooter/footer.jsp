<%-- 
    Document   : header
    Created on : 19.10.2016, 20:23:15
    Author     : Niklas
--%>

<script>
    function init_map() {

	var var_location = new google.maps.LatLng(40.725118, -73.997699);

	var var_mapoptions = {
	    center: var_location,
	    zoom: 14
	};

	var var_marker = new google.maps.Marker({
	    position: var_location,
	    map: var_map,
	    title: "New York"
	});

	var var_map = new google.maps.Map(document.getElementById("map-container"),
		var_mapoptions);

	var_marker.setMap(var_map);

    }

    google.maps.event.addDomListener(window, 'load', init_map);
</script>

<!-- Animations init-->
<script>
    new WOW().init();
</script>