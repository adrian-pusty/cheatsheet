mkdir -p 	# No error if existing, make parent directories as needed
top -c | grep 12345 # PID instead of 12345

ls -1 .		# Listing files in a single column
ls -lh    # -h, --human-readable # print sizes like 1K 234M 2G etc.

cat file1 file2 file3 >> output # merging file1, file2 and file3 to output file

#for loop
for x in a b c d e f; do
    echo letter:${x}
done