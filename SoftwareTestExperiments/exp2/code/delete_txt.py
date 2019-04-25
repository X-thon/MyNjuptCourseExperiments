import os, glob

if __name__ == "__main__":
    for i in range(1, 101):
        file_list = glob.glob(str(i) + "_*.txt")
        for name in file_list:
            os.remove(name)