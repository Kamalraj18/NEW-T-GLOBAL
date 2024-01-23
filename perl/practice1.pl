@arrays = (1,2,3,4);
$mystring = join("-",@arrays);
print("$mystring\n\n");

foreach $a(@arrays){
    print($a);
}