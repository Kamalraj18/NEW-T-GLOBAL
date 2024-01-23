# Get the list of names
sub build_list_of_names{
    @my_list = ();
    $filename = 'C:\Users\kamal\Desktop\perl\name.txt';
    open(FILE, "<",$filename);
    while(chomp($name = <FILE>)){
        push(@my_list, $name);
    }
    close(FILE);
}

#Menu options

sub get_user_option
{
    print("\n1. Search for customer\n");
    print("\n2. Add new customer\n");
    print("\n3. Get All customer\n");
    print("\n4. Quit\n");

    print("\nSelect an option: ");
    chomp($option_selected = <STDIN>);
    chomp();

    return $option_selected;
}

sub get_customers{
    print("\nCustomers:\n\n");
    my $count = 0;
    foreach $names_list(@my_list){
        $count +=1;
        print("$count. $names_list\n");
    }
}

# Add new customer
sub add_new_customer{
print("\nEnter name of new customer: ");
chomp($the_new_cus = <STDIN>);
$exit_status = push(@my_list,$the_new_cus);
if($exit_status){
    print("\nNew Customer Added.\n");
}
else{
    print("\nSomething went Wrong");
}
}

#seatch customer

sub search_for_customer{
    print("\nEnter name of customer: ");
    chomp($name_of_customer = <STDIN>);

    foreach $name (@my_list){
        if(lc($name_of_customer) eq lc($name)){
            print("\n$name was found\n");
            return;
        }
    }
}

# Main code
&build_list_of_names();
$option_select = &get_user_option();
while($option_select!=4){
    if($option_select == 1){
        &search_for_customer();
        $option_select = &get_user_option();
    }
    elsif($option_select==2){
        &add_new_customer();
        $option_select = &get_user_option();
    }
    elsif($option_select == 3){
        &get_customers();
        $option_select = &get_user_option();
    }
    else{
        print("\nPlease select a valid option");
        $option_select = &get_user_option();
    }
}

$filename = 'C:\Users\kamal\Desktop\perl\name.txt';
open(FILE, ">",$filename);
foreach $name (@my_list){
    chomp($name);
    print(FILE "$name\n");
}
close(FILE);
print("\nExiting");
exit;