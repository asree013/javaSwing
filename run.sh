#!/bin/bash

# เข้าไปในโฟลเดอร์ src
cd src

# Compile ไฟล์ .java ทั้งหมด
javac packages/*.java interfaces/*/*.java screen/*/*.java Main.java models/*/*.java services/*/*.java configs/*/*.java

# ตรวจสอบว่าการ compile สำเร็จหรือไม่
if [ $? -eq 0 ]; then
    echo "Compilation successful."

    # กลับไปโฟลเดอร์หลัก
    cd ..

    # สร้างไฟล์ .jar พร้อม Main class และตั้งชื่อเป็น emsLauncher.jar
    jar cfe emsLauncher.jar Main -C src .

    # ตรวจสอบสิทธิ์ของไฟล์ (สำหรับ Linux/Mac)
    chmod +x emsLauncher.jar

    # ทดสอบรันไฟล์ .jar
    java -jar emsLauncher.jar
else
    echo "Compilation failed."
fi
