$_ = "the error was in line number 55";
# i refers incase sensitive
if(/[0-6][0-6]/){
    print("found");
}
else{
    print("not found");
}

# -------------------------------------------------------------------------------------

$_ = "the error was in line number 55";
# s/// this used to replace words which are matching
s/Error/bug/i;
# s///gi g used to change every words that present
# i refers incase sensitive
if(m%bug%){
    print("found");
}
else{
    print("not found");
}

# compare with other variables

$value = "kamal raj";
if($value =~ /raj/){
    print("matched");
}
else{
    print("not matched");
}

# ------------------------

$data = "the error was in line number 55";
@arrays = split(/ /,$data);