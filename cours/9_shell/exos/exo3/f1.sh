function ma_fonction() {

var1="$1"
var2="$2"

	if [ echo"${#var1}" == echo"${#var2}" ]; then
			echo "$1 est de meme taille que $2";
		elif [ echo"${#var1}" < echo"${#var2}" ]; then
			echo "$1 est plus grand que $2"
		else 
			echo "$1 est plus petit que $2"
   
	fi
}   
var=$(ma_fonction $1 $2)
echo


[ echo"${#var1}" < echo"${#var2}" ]; then