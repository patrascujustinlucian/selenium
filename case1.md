# test
test
Dear Adam
Thank you for your case submission!
Regarding your inquiry i would have to provide you with the following sollution:
The first thing to do is to add an empty circle.yml file to the root directory of your repository.

In case you need to have checked-out submodules it is reccomended you add the appropriate commands:
checkout:
  post:
    - git submodule sync
    - git submodule update --init
    
    
hope this was useful

bests
Lucian
