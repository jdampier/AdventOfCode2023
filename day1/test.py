input = open('day1\\input.txt')

total = 0
for line in input:
    num1 = -1
    num2 = -1
    for digit in line:
        if digit in ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0']:
            if num1 == -1:
                num1 = digit
            else:
                num2 = digit
    if num2 != -1:
        total += (int(num1) * 10) + int(num2)
    else:
        total += (int(num1) * 10) + int(num1)

print(total)