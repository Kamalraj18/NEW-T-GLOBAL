$filename = 'C:\Users\kamal\Desktop\New folder\TUTORIAL.txt';
open($fh,"<",$filename);
while($row = <$fh>)
{
    chomp($row);
    print($row,"\n");
}