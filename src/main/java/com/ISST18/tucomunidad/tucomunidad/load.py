import requests

loadusers = requests.get("http://localhost:8090/api/v1/usuario/load")
loadcomunity = requests.get("http://localhost:8090/api/v1/comunidad/load")
loadposts = requests.get("http://localhost:8090/api/v1/post/load")
loadinstalaciones = requests.get("http://localhost:8090/api/v1/instalacion/load")
