print("enter:\n");
$a = <STDIN>;

if($a>60){
print($a);}
else{
    print("no");
}
# array
@data = ("kamal",25,"gojo");
print("$data[0] \n$data[1]\n");

# list
@list_array = qw/ rajini kamal 171 250 /;
print("@list_array\n");
($list_array[0], $list_array[2]) = ("thalaiva",170);
print("@list_array\n")

