from __future__ import print_function
import sys
import datetime
import random
import threading


def main(n, no_threading):
    start = -86400 * 365 * 20
    end = 86400 * 365
    filename = 'testdata-' + str(n) + '.txt'
    with open(filename, 'w') as fp:
        now = datetime.datetime.now()
        for i in range(n):
            d = datetime.timedelta(seconds=random.randint(start, end))
            nd = now + d
            fp.write(nd.strftime("%d/%m/%Y %H:%M:%S") + '\n')
    print('generate finish {}\n'.format(filename))


if __name__ == '__main__':
    if not(len(sys.argv) == 3 and sys.argv[1].isdigit() and sys.argv[2].isdigit()):
        print('bad input, argument must be number\n')
        exit()
    n = int(sys.argv[1])
    m = int(sys.argv[2])
    main(n)
