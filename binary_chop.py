
def test(chop):
    args=[-2, -1, 0, 4, 9]
    n=0
    for i in range(0, len(args)):
#        print('assert chop(%s, %s)==%d, "error! at test #"+str(%d)' %(str(args[i]), str(args), i, i))
        ret=chop(args[i], args)
        assert ret == i, "error! at test #"+str(n+i)+" expected: "+str(i)+" returned: "+str(ret)
    n=i+1
    assert chop(100, args) == -1, "error! at test #"+str(n)

    args=[-2, -1, 0, 4]
    for i in range(0, len(args)):
        ret=chop(args[i], args)
        assert ret == i, "error! at test #"+str(n+i)+" expected: "+str(i)+" returned: "+str(ret)

def dummyChop(key, array):
    pass

def recursiveChop(key, array):
    n = len(array)
    if n == 0:
        return -1
    if n == 1:
        if array[0] == key:
            return 0
        else:
            return -1

    if array[n/2] > key:
        tmp=recursiveChop(key, array[:n/2])
        if tmp != -1:
            return tmp
        else:
            return -1
    else:
        tmp=recursiveChop(key, array[n/2:])
        if tmp != -1:
            return tmp+n/2
        else:
            return -1

if __name__ == "__main__":
    test(recursiveChop)
#    test(dummyChop)
