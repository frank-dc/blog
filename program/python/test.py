import asyncio

async def say_hello():
    print("Hello")
    await asyncio.sleep(5)   # 模拟异步 I/O，非阻塞地等待 1 秒
    print("World")



if __name__ == '__main__':
    asyncio.run(say_hello())
