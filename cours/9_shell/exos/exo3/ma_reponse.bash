
for i in $( cat salim.txt ); do




if [[ $i =~ ";mme;" ]]; then
              echo "$i">> femme.txt
      else echo "$i" >> homme.txt

fi




done



