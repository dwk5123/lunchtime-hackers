use strict;

for (my $i = 0; $i <= 600; $i++) {
	if ($i % 5 == 0) {
		print 'Yummy';
	} 
	if ($i % 9 == 0) {
		print 'Tummy';
	}
	if (	($i % 5 != 0) &&
		($i % 9 != 0)) {
		print $i;
	}
	print "\n";
} 
