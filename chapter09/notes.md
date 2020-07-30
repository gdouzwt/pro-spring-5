### 事务的属性

没法控制事务的原子性、一致性和持久性，但是可以控制事务的传播和超时。Spring 将这些封装在 `TransactionDefinition` 接口里边。
这个接口被用于支持核心事务的 `PlatformTransactionManager`。

### 事务隔离级别
ISOLATION_DEFAULT
ISOLATION_READ_UNCOMMITTED
ISOLATION_READ_COMMITTED
ISOLATION_REPEATABLE_READ
ISOLATION_SERIALIZABLE
