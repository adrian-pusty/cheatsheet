mkdir -p 	# No error if existing, make parent directories as needed
top -c | grep 12345 # PID instead of 12345

ls -1 .		# Listing files in a single column
ls -lh    # -h, --human-readable # print sizes like 1K 234M 2G etc.

du -sm *  # ~howtogeek.com/168135/list-files-and-directories-by-size-on-linux/
du -sh abc* | sort -rh # sort by size

cat file1 file2 file3 >> output # merging file1, file2 and file3 to output file

find . -name '*java' -mtime +10 -newer App.java

echo $((0xF)) # Prints 15

#for loop
for x in a b c d e f; do
    echo letter:${x}
done