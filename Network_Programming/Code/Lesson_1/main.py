import socket
if __name__ == '__main__':
    # Lay ten may
    hostname = socket.gethostname()
    print(hostname)
    ip_addr = socket.gethostbyname(hostname)
    print(ip_addr)

    # Lay dia chi cua ten may
    python_addr = socket.gethostbyname('www.python.org')
    print(python_addr)

