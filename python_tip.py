# 格式输出, HH:MM:SS
def make_readable(s):
    return "{:02}:{:02}:{:02}".format(int(s / 3600), int(s / 60 % 60), s % 60)

# 三数相加的fibonacci, 
# Test.assert_equals(tribonacci([1, 1, 1], 10), [1, 1, 1, 3, 5, 9, 17, 31, 57, 105])
def tribonacci(signature, n):
    while len(signature) < n:
        signature.append(sum(signature[-3:]))
    
    return signature[:n]

# https://www.codewars.com/kata/the-supermarket-queue/train/python
# 解决多线程的思路，线程数的list，对最小值叠加后，取最大 
# heap，时间更优
def queue_time(customers, n):
    heap = [0] * n
    for time in customers:
        heapq.heapreplace(heap, heap[0] + time)
    
    return max(heap)

# closure, nested function can carry parent function's state
def make_adder(n):
	def add(x):
		return x + n
	return add

plus_3 = make_adder(3)
plus_5 = make_adder(5)

assert plus_3(4) == 7, "3 + 4 == 7"
assert plus_5(4) == 9, "5 + 4 == 9"
