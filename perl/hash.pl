%hash = ("name"=>"kamal","location"=>"vellore");
$hash{"id"}=1;
foreach $value( values(%hash)){
print("$value\n");
}
@keys = keys(%hash);
print(@keys);