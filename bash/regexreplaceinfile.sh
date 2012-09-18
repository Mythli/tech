Output='judas'
echo 'Last replace was : '$Output

cat ./regexreplaceinfile.sh | sed -e "s/$Output/$1/" > ./.tmp_regexreplaceinfile.sh
mv ./.tmp_regexreplaceinfile.sh ./regexreplaceinfile.sh
chmod +x ./regexreplaceinfile.sh