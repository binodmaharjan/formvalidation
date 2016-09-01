uses

Form form=new Form(this);
form.check(editText,RegexTemplate.Email,"error msg");
form.validate();

form validation

// maven
<dependency>
  <groupId>com.binod.maharjan</groupId>
  <artifactId>formvalidation</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>

compile 'com.binod.maharjan:formvalidation:1.0.1'
