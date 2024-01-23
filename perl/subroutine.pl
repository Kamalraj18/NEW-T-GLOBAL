sub add_numbers(){
    $a = $_[0];
    print("$a");
    if($a > 18){
    return "valid user";
    }
    else{
return "not allowed";
}
}

$value = <STDIN>;
print(&add_numbers($value));