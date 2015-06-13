# Compiler
JC = javac

# Directories
SRCDIR = src
CLSSDIR = classes

# Sources
SOURCES := $(shell find $(SRCDIR) -name '*.java')
OBJECTS := $(SOURCES:$(SRCDIR)/%.java=$(CLSSDIR)/%.class)

#FLAGS
JFLAGS = -g -deprecation -d $(CLSSDIR)

$(OBJECTS): $(SOURCES)
	@[ -d $(CLSSDIR) ] || mkdir $(CLSSDIR)
	$(JC) $(JFLAGS) $(SOURCES)

# Helpers
clean:
	rm -rf $(CLSSDIR)

print_vars:
	@echo SOURCES = $(SOURCES)
	@echo OBJECTS = $(OBJECTS)

run: $(OBJECTS)
	@java -cp $(CLSSDIR) vm.Test

PHONY: clean test run teststepped
