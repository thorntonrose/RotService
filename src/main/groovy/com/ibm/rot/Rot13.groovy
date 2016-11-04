package com.ibm.rot

/**
 * Rot13 cipher.
 * 
 * @author thorntonrose
 */
class Rot13 {
	String upper = { text -> return text.toUpperCase() }

	String rot(String text) {
		def rotted = ""

		text?.toCharArray().each { c ->
		  if (c in 'a' .. 'm' || c in 'A' .. 'M') rotted += (c+13) as char
		  else if (c in 'n' .. 'z' || c in 'N' .. 'Z') rotted += (c-13) as char
		  else rotted += c
		}

		return rotted
	}

	static void main(String[] args) {
		println (args.size() == 0 ? "usage: rot13 <text>" : new Rot13().rot(args[0]))
	}
}