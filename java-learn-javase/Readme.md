# 原来这是个普通的java项目，改成了Maven项目，造成的后果是`IO`流的那一块的路径不对，其实如果是放在根目录下的就是对的，但是放在了`Resources`文件夹下的话就会报错