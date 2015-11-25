# Hibernate Issue: @Column annotation is disregarded for entities in an @ElementCollection if owning entity uses AccessType.PROPERTY for @Id field #

Reproducible failing unit test for the [Hibernate ElementCollection / AccessType issue (HHH-10330)][HHH-10330].


## Howto ##

Prerequisites:
  - Java 6+

On Linux:

```
# ./gradlew --info build
```

On Windows:

```
# gradlew --info build
```

## On Travis ###

[![Build Status](https://travis-ci.org/bwaldvogel/hibernate-element-collection-access-type.png?branch=master)](https://travis-ci.org/bwaldvogel/hibernate-element-collection-access-type)

[HHH-10330]: https://hibernate.atlassian.net/browse/HHH-10330
