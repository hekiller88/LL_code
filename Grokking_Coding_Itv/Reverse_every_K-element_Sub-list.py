from __future__ import print_function


class Node:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next

    def print_list(self):
        temp = self
        while temp is not None:
            print(temp.value, end=" ")
            temp = temp.next
        print()


def reverse_every_k_elements(head, k):
    if not head or k <= 1:
        return head

    prev, curr = None, head
    first_of_prev = prev
    while curr:

        first_of_curr = curr

        tmp, prev = 0, None
        while curr and tmp < k:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
            tmp += 1

        if first_of_prev:
            first_of_prev.next = prev
        else:
            head = prev

        first_of_prev = first_of_curr

    return head


def main():
    head = Node(1)
    head.next = Node(2)
    head.next.next = Node(3)
    head.next.next.next = Node(4)
    head.next.next.next.next = Node(5)
    head.next.next.next.next.next = Node(6)
    head.next.next.next.next.next.next = Node(7)
    head.next.next.next.next.next.next.next = Node(8)

    print("Nodes of original LinkedList are: ", end='')
    head.print_list()
    result = reverse_every_k_elements(head, 2)
    print("Nodes of reversed LinkedList are: ", end='')
    result.print_list()


main()







