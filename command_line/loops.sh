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

for value in "${arr[@]}";
do
    some_function "$value"
done