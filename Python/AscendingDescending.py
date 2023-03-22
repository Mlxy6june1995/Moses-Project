import random
	
def create_a_number_sequence():
	sequence = []
	counter = 0

	while counter < 10:
		sequence.append(random.randint(0, 100))
		counter += 1
	return sequence

def check_ascending(sequence):
	result = False	
	for x in range(len(sequence)-1):
		if sequence[x] < sequence[x+1]:
			result = True
		else:
			result = False
			break
	return result

def become_ascending(sequence):
	for x in range(0, len(sequence)):
		for y in range(x+1, len(sequence)):
			if sequence[x] > sequence[y]:
				temp = sequence[x]
				sequence[x] = sequence[y]
				sequence[y] = temp
	return sequence

def check_descending(sequence):
	result = False	
	for x in range(len(sequence)-1):
		if sequence[x] > sequence[x+1]:
			result = True
		else:
			result = False
			break
	return result

def become_descending(sequence):
	for x in range(0, len(sequence)):
		for y in range(x+1, len(sequence)):
			if sequence[x] < sequence[y]:
				temp = sequence[x]
				sequence[x] = sequence[y]
				sequence[y] = temp
	return sequence


sequence_1 = create_a_number_sequence()
sequence_2 = create_a_number_sequence()
sequence_3 = create_a_number_sequence()

print()
print()
print("Checking and Sorting Ascending")
print("Original:", sequence_1)
if (check_ascending(sequence_1) == False):
	print("It is not in ascending order")
	print("Sorted:", become_ascending(sequence_1))
else:
	print("It is in ascending order")
print()

print("Original:", sequence_2)
if (check_ascending(sequence_2) == False):
	print("It is not in ascending order")
	print("Sorted:", become_ascending(sequence_2))
else:
	print("It is in ascending order")
print()

print("Original:", sequence_3)
if (check_ascending(sequence_3) == False):
	print("It is not in ascending order")
	print("Sorted:", become_ascending(sequence_3))
else:
	print("It is in ascending order")

print()
print()

print("Checking and Sorting Descending")
print("Original:", sequence_1)
if (check_descending(sequence_1) == False):
	print("It is not in descending order")
	print("Sorted:", become_descending(sequence_1))
else:
	print("It is in descending order")
print()

print("Original:", sequence_2)
if (check_descending(sequence_2) == False):
	print("It is not in descending order")
	print(become_descending(sequence_2))
else:
	print("It is in descending order")
print()

print("Original:", sequence_3)
if (check_descending(sequence_3) == False):
	print("It is not in descending order")
	print("Sorted:", become_descending(sequence_3))
else:
	print("It is in descending order")