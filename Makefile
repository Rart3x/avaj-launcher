SRC_DIR := src/com/avaj
TRANSPORTS_DIR := $(SRC_DIR)/transports
UTILS_DIR := $(SRC_DIR)/utils

JC := javac

SOURCES := $(wildcard $(SRC_DIR)/*.java) $(wildcard $(TRANSPORTS_DIR)/*.java) $(wildcard $(UTILS_DIR)/*.java)

MAIN_CLASS := Main

GREEN = \033[0;32m
RESET = \033[0m

default: compile

compile:
	@echo "$(GREEN)Compiling dependencies...$(RESET)"
	@$(JC) $(SOURCES)

fclean:
	@echo "$(GREEN)Class obj cleaned.$(RESET)"
	@find $(SRC_DIR) -name "*.class" -type f -exec rm {} \;

.PHONY: default compile fclean