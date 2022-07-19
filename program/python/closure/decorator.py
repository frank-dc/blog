import time
from functools import wraps

def log_no_args(func):      # 装饰器本身不传入参数
    def wrapper(*args, **kwargs):
        print("call %s():" % func.__name__)
        return func(*args, **kwargs)
    return wrapper


def log_with_args(action):  # 装饰器本身传入参数
    def decorator(func):
        def wrapper(*args, **kwargs):
            print(f"{action} {func.__name__}():")
            return func(*args, **kwargs)
        return wrapper
    return decorator


#@log_no_args               # 相当于 now = log_no_args(now)
@log_with_args("execute")   # 相当于 now = log_with_args("execute")(now)
def now(name="alvin"):
    t = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
    print(f"Hello {name}, it's {t}")


if __name__ == '__main__':
    now()
    now("simon")