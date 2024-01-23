$filename = 'C:\Users\kamal\Desktop\New folder\TUTORIAL.txt';
open($fh, ">>", $filename);
print($fh "\n{Rohit}");
print($fh "\n{Bharath}");
close($fh);
