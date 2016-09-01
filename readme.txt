uses

         Form form = new Form(this);
        form.check(editText, RegexTemplate.NOT_EMPTY_PATTERN, "field is empty ");
        form.check(editText2, RegexTemplate.EMAIL_PATTERN, "Not a valid email pattern ");
        form.checkLength(editText2, Range.equal(10), "must be of length 10 ");
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
