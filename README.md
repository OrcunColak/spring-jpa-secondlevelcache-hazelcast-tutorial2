This project demonstrates using Hibernate 2nd level cache as Hazelcast client  

# Call flow
org.hibernate.cache.spi.AbstractRegionFactory()
org.hibernate.cache.spi.AbstractRegionFactory#start
org.hibernate.cache.spi.AbstractRegionFactory#prepareForUse