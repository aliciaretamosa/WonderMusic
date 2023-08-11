# WonderMusic
Para utilizar la aplicacion es necesario solicitar un token que caduca en 3600 segundos, apartir de esta llamada

curl -X POST "https://accounts.spotify.com/api/token" \
     -H "Content-Type: application/x-www-form-urlencoded" \
     -d "grant_type=client_credentials&client_id=0a4a7631db204fe3be2f4816335ece86&client_secret=5c78885f4ed54deb8fd0c3125a99a7ff"

y actualizar el token en la clase ArtistApi ubicada en com.example.wondermusic.data.remote
