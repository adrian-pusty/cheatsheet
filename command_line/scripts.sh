xdg-open # opens a file or URL in the user's preferred application
xdg-open "https://google.com" & xdg-open "https://youtube.com" # &

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
arr2=(4 5 6)
echo ${arr[1]}
echo "${arr[@]: -2}"    # last two elements
echo "${arr[@]: -1}"    # last element        # echo "${result[-1]}"
echo "${arr[@]: -2: 1}" # second to last      # echo "${result[-2]}"
arr+=("${arr2[@]}")