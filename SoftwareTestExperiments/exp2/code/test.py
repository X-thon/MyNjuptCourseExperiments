import os, glob

# 比较返回结果，如果相同，则为True，否则为False
def compare_fuc(list1, list2)->bool:
    if len(list1) != len(list2):
        return False
    for i in range(len(list1)):
        if list1[i] != list2[i]:
            return False
    return True

if __name__ == "__main__":
    for j in range(1,8):
        print("第" + str(j) + "个程序")
        errorFileList = set()
        testFileName = "count" + str(j)

        for i in range(1,101):
            # 匹配符合规则的文件名
            file_list = glob.glob(str(i) + "_*.txt")
            file_argument = ' '.join(file_list)
            # 通过os.popen执行命令行语句
            res1 = os.popen("./count.out " + file_argument)
            res2 = os.popen("./" + testFileName + ".out" + " " + file_argument)
            #print("res1: ", res1.readlines())
            #print("res2: ", res2.readlines())
            if compare_fuc(res1.readlines(), res2.readlines()) is False:
                # 将存在差异的配置方案存储下来
                errorFileList.add(i)
        #print(sorted(list(errorFileList)))
        #print(len(errorFileList))

        with open("pict_output.txt", "r") as f:
            lines = f.readlines()
            with open(testFileName + ".o", "w") as fout:
                for lineId in sorted(list(errorFileList)):
                    #因为errorFileList中存的是配置标号，对应的下标为：配置号-1
                    fout.write(lines[lineId-1])
        
    