xdg-open # opens a file or URL in the user's preferred application
command1 & command2 & command3 # https://askubuntu.com/questions/990423/how-can-i-run-multiple-commands-which-have-in-one-command-line

#for loop
for x in a b c d e f; do
    echo letter:${x}
done

# replace spaces in file names in provided path # https://stackoverflow.com/a/18213120/15493760, https://stackoverflow.com/a/5928254/15493760
for file in /some/path/*
do
        mv "$file" "${file// /_}"
done

# for loop + if statement
END=99
for ((i=1;i<=END;i++)); do
    if (($i%2 == 1))
    then
        echo $i;
    fi
done

read -r val1
read -p "Please enter second value: " val2
echo $((${val1}+val2))

if [ ${val1} -gt ${val2} ]; then
	echo "val1 is greater than val2";
fi

if [ "${val1}" == 'Y' ] || [ ${val1} == 3 ] # note the spaces after '[' and before ']'
then 
	echo "val1 is equal to 'Y' or 3";
elif ((${val1} < ${val2})) # won't work with -lt
then 
	echo "val1 is less than val2 and not equal to 'Y' or 3";
fi

# if ((${val1} -lt ${val2})) # won't work with -lt # error
# then
# 	echo "val1 is less than val2";
# fi

arr=(1 2 3)
echo ${arr[1]}